@Library('jnks-sharedlib-updatesettings')

import src.settings.GetImageName
import src.settings.UpdateSettings

def initSettings() {
    // Load the initSettings script
    load "vars/initSettings.groovy"
}

pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Checkout the repository
                checkout scm

                // Execute the initSettings step
                script {
                    initSettings()
                }
            }
        }
    }
}
