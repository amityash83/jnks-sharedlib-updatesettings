import settings.GetImageName
import settings.UpdateSettings

def call() {
	def jobName = env.JOB_NAME
	def matchedImgName = GetImageName.parseImageName(jobName)
	
	if (matchedImgName) {
		UpdateSettings.updateSettingsYaml(matchedImgName)
	} else {
		println "Failed to get details"
	}
}