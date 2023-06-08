package settings

import org.yaml.snakeyaml.DumperOptions
import org.yaml.snakeyaml.Yaml

class UpdateSettings {
	
	static void updateSettingsYaml(String matchedImgName) {
		def settingFilePath = libraryResource('resources/settings.yaml')
		def settingFile = new Yaml().load(settingFilePath)
		
		def podTemplateFilePath = libraryResource('conf/podTemplate.yaml')
		def podTemplateFile = new Yaml().load(podTemplateFilePath)
		
		if (settingFile.serviceAccounts.contains(matchedImgName)) {
			def matchedSvcAccount = settingFile.serviceAccounts[matchedImgName]
			podTemplateFile.spec.serviceAccountName = matchedSvcAccount
			
			def dumperOptions = new DumperOptions()
			dumperOptions.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK)
			def yaml = new Yaml(dumperOptions)
			
			def updatePodTemplateContents = yaml.dump(podTemplateFile)
			def updatePodTemplateFile = libraryResource(conf/podTemplate.yaml).getFile()
			updatePodTemplateFile.write(updatePodTemplateContents)
			
			println updatePodTemplateFile
		} else {
			println "No SA found for ${matchedImgName} in settings.yaml"
		}
	}
}