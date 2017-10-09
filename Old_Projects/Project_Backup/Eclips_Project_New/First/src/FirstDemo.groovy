import jenkins.model.*
def instance = Jenkins.getInstance()

// set email
def location_config = JenkinsLocationConfiguration.get()
location_config.setAdminAddress("jenkins@azsb.skybet.net")