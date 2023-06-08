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
    
    // Define the initSettings function as a closure
    def initSettings = {
        // Load the initSettings script
        load "vars/initSettings.groovy"
    }
}
