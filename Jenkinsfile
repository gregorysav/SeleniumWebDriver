pipeline {
    agent  any
     parameters {
            choice(name: 'role', choices: ['ta', 'tu'], description: 'Pick which role should the tests run against')
    }
    tools {
        maven 'M3'
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/gregorysav/SeleniumWebDriver'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                sh "mvn clean test -P${params.role}"
            }
        }
    }
}