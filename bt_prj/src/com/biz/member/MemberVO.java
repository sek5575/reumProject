package com.biz.member;

public class MemberVO {
	// 프로퍼티  
		private int userSeq;
		private String userId;
		private String userName;
		private String userPw;
		private String userEmail;
		private String userGubun;
		private String regdate;
		private String userDel;
		
		//사진 프로필
		private String pname;
		private String ppath;
		private String sysname;
		private String join_path;
		
		//검색
		private String searchGubun;
		private String searchStr;
		
		
		
		public String getSearchGubun() {
			return searchGubun;
		}
		public void setSearchGubun(String searchGubun) {
			this.searchGubun = searchGubun;
		}
		public String getSearchStr() {
			return searchStr;
		}
		public void setSearchStr(String searchStr) {
			this.searchStr = searchStr;
		}
		public String getPname() {
			return pname;
		}
		public void setPname(String pname) {
			this.pname = pname;
		}
		public String getPpath() {
			return ppath;
		}
		public void setPpath(String ppath) {
			this.ppath = ppath;
		}
		public String getJoin_path() {
			return join_path;
		}
		public void setJoin_path(String join_path) {
			this.join_path = join_path;
		}
		public String getSysname() {
			return sysname;
		}
		public void setSysname(String sysname) {
			this.sysname = sysname;
		}
		public int getUserSeq() {
			return userSeq;
		}
		public void setUserSeq(int userSeq) {
			this.userSeq = userSeq;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getUserPw() {
			return userPw;
		}
		public void setUserPw(String userPw) {
			this.userPw = userPw;
		}
		public String getUserEmail() {
			return userEmail;
		}
		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}
		public String getUserGubun() {
			return userGubun;
		}
		public void setUserGubun(String userGubun) {
			this.userGubun = userGubun;
		}
		public String getRegdate() {
			return regdate;
		}
		public void setRegdate(String regdate) {
			this.regdate = regdate;
		}
		public String getUserDel() {
			return userDel;
		}
		public void setUserDel(String userDel) {
			this.userDel = userDel;
		}
		
		
		
}
