pipeline{
    agent any
    stages{
        stage('Build'){
            steps{
                bat 'mvn clean compile test package'
            }
        }
        stage('SonarQube Analysis'){
            steps{
                withSonarQubeEnv(credentialsId: 'token-for-jenkins') {
                    bat 'mvn sonar:sonar'
                }
            }
        }
        stage{
            steps('JaCoCo'){
                jacoco()
            }
        }
        stage('Deploy'){
            steps{
                waitForQualityGate abortPipeline: false, credentialsId: 'token-for-jenkins'
                deploy adapters: [tomcat9( credentialsId: 'tomcat-9-token', path: '', url: 'http://localhost:8088/')], contextPath: null, onFailure: false, war: '**/*.war'
            }
        }
    }
}