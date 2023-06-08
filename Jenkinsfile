pipeline {
    agent any
    
    stages {
        stage('Run initSettings') {
            steps {
                script {
                    // Clone the repository or checkout the code from version control
                    
                    // Set up the necessary environment variables, if required
                    
                    // Run the initSettings script
                    load 'scripts/initSettings.groovy'
                    InitSettings.init()
                }
            }
        }
    }
}
