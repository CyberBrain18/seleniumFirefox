pipeline {
    agent any

    tools {
        maven 'Maven' 
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/your-username/FirefoxMultiTabAutomation.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Run Multi-Tab Tests') {
            steps {
                // Runs the multi-site login automation
                sh 'mvn exec:java -Dexec.mainClass="com.example.App"'
            }
        }
    }

    post {
        always {
            echo 'Firefox Multi-Tab Automation Execution Finished.'
        }
    }
}
