package bbs;
	

	public class Bbs {
		private int board_id;
		private int bbs_id;
		private String user_id;
		private String bbsDate;
		private String bbsContent;
		private int bbsAvailable;
		public int getBoard_id() {
			return board_id;
		}
		public void setBoardID(int board_id) {
			this.board_id = board_id;
		}
		public int getBbs_id() {
			return bbs_id;
		}
		public void setBbs_id(int bbs_id) {
			this.bbs_id = bbs_id;
		}

		public String getUser_id() {
			return user_id;
		}
		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}
		public String getBbsDate() {
			return bbsDate;
		}
		public void setBbsDate(String bbsDate) {
			this.bbsDate = bbsDate;
		}
		public String getBbsContent() {
			return bbsContent;
		}
		public void setBbsContent(String bbsContent) {
			this.bbsContent = bbsContent;
		}

		public int getBbsAvailable() {
			return bbsAvailable;
		}
		public void setBbsAvailable(int bbsAvailable) {
			this.bbsAvailable = bbsAvailable;
		}
	}

