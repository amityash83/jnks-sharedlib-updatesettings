import settings.GetImageName
import settings.UpdateSettings

def call() {
	// def jobName = env.JOB_NAME
    def jobName = to-image-rhel8-gen
	def matchedImgName = GetImageName.parseImageName(jobName)

    println "================================================="
    println "Jenkins Job Name  : ${jobName}"
    println "Matched Image Name: ${matchedImgName}"
    println "================================================="
	
	if (matchedImgName) {
		UpdateSettings.updateSettingsYaml(matchedImgName)
	} else {
		println "Failed to get details"
	}
}