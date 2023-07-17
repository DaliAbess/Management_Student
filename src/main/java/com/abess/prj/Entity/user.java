package com.abess.prj.Entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity 
@Table(name="users")
public class user {


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ; 
		@Column(name="login",nullable=false )
	private  String login ;
		@Column(name="password",nullable=false )
	private  String password ;
		
		public user( ) {

		}
		public user( String login, String password) {
			super();
			
			this.login = login;
			this.password = password;
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getlogin() {
			return login;
		}
		public void setlogin(String login) {
			this.login = login;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		@Override
		public int hashCode() {
			
			return Objects.hash(password); 
		}
		@Override
		public boolean equals(Object obj) {
			if(this==obj) return true ;
			if(obj==null || getClass()!=obj.getClass()) return false ;
			user that =(user) obj ; 
			return Objects.equals(login, that.login)&& Objects.equals(password, that.password) ;
		}
		@Override
		public String toString() {
			
			return "user"+id+"login"+login;
		}


	}

