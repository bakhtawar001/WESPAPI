package Pojo;

import java.util.List;

public class CreateProject {
	
	
		private String appCode;
		private String appVersion;
		private String projectName;
		private int parentProjectIds;
		
		
		public String getAppCode() {
			return appCode;
		}
		public void setAppCode(String appCode) {
			this.appCode = appCode;
		}
		public String getAppVersion() {
			return appVersion;
		}
		public void setAppVersion(String appVersion) {
			this.appVersion = appVersion;
		}
		public String getProjectName() {
			return projectName;
		}
		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}
		public int getParentProjectIds() {
			return parentProjectIds;
		}
		public void setParentProjectIds(int parentProjectIds) {
			this.parentProjectIds = parentProjectIds;
		}
		
		
		@Override
		public String toString() {
			return "CreateProject [appCode=" + appCode + ", appVersion=" + appVersion + ", projectName=" + projectName
					+ ", parentProjectIds=" + parentProjectIds + ", Projects=" + "]";
		}
		public CreateProject(String appCode, String appVersion, String projectName, int parentProjectIds) {
			super();
			this.appCode = appCode;
			this.appVersion = appVersion;
			this.projectName = projectName;
			this.parentProjectIds = parentProjectIds;
		}
	
		
	  

}
