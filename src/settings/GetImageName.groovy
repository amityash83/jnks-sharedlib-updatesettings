package settings

class GetImageName {
	static String parseImageName(String jobName) {
		def matchedImgName = jobName =~ /\/to-image-(.*?)(?=\/|$)/
		if (matchedImgName) {
			return matchedImgName[0][1]
		} else {
			return null
		}
	}
}