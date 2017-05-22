/**
 * 
 */
package com.objis.demospringsecurity.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.objis.demospringsecurity.domaine.Personne;

/**
 * @author OBJIS : www.objis.com
 *
 */
@Repository("employeDAO")
public class PersonneJdbcDaoSupport extends JdbcDaoSupport  implements IPersonneDao 
{

	@SuppressWarnings("unchecked")
	public Personne getPersonneById(int id) {
		final String Personne_BY_ID =
			"SELECT * " +
			"FROM Personne " +
			"WHERE id = ?";

		RowMapper mapper = new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum)
			throws SQLException {
				Personne Personne = new Personne();
				Personne.setId(rs.getLong("id"));
				Personne.setLogin(rs.getString("login"));
				Personne.setPassword(rs.getString("password"));
				Personne.setNom(rs.getString("nom"));
				Personne.setPrenom(rs.getString("prenom"));
				Personne.setEmail(rs.getString("email"));
				Personne.setCountry(rs.getString("pays"));
				Personne.setEnabled(rs.getBoolean("enabled"));
				return Personne;
			}
		};

		return (Personne) getJdbcTemplate().queryForObject(Personne_BY_ID, new Object[] { id }, mapper);
	}


	public int getPersonnesCount() {
		final String Personne_COUNT =
			"SELECT COUNT(*) " +
			"FROM utilisateurs";

		return getJdbcTemplate().queryForObject(Personne_COUNT, Integer.class);
	}

	
	public void savePersonne(Personne Personne) {
		final String PERSONNE_INSERT =
			"INSERT INTO utilisateurs(" +
				"login, password, nom, prenom, email, pays, enabled" +
			") VALUES(" +
				"?, ?, ?, ?, ?, ?, ?" +
			")";
	
		getJdbcTemplate().update(
				PERSONNE_INSERT,
				new Object[] { Personne.getLogin(), Personne.getPassword(),
						Personne.getPrenom(), Personne.getNom(),
						Personne.getEmail(), Personne.getCountry(),Personne.getEnabled()});
	}

	
	@SuppressWarnings("unchecked")
	public List<Personne> getAllPersonnes() {
		final String PERSONNE_ALL =
			"SELECT * " +
			"FROM utilisateurs";

		List<Personne> queryForList = getJdbcTemplate().queryForList(PERSONNE_ALL, Personne.class);
		
		return queryForList;
	}


	
	public Personne loadPersonneByUsername(String username) {
		final String PERSONNE_BY_LOGIN =
			"SELECT * " +
			"FROM Personne " +
			"WHERE login = ?";

		RowMapper mapper = new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum)
			throws SQLException {
				Personne Personne = new Personne();
				Personne.setId(rs.getLong("id"));
				Personne.setLogin(rs.getString("login"));
				Personne.setPassword(rs.getString("password"));
				Personne.setNom(rs.getString("nom"));
				Personne.setPrenom(rs.getString("prenom"));
				Personne.setEmail(rs.getString("email"));
				Personne.setCountry(rs.getString("pays"));
				return Personne;
			}
		};

		return (Personne) getJdbcTemplate().queryForObject(PERSONNE_BY_LOGIN, new Object[] { username }, mapper);
	}

}