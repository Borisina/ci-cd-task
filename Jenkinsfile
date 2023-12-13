pipeline{
    agent any
    stages{
        stage ('Initialize') {
            steps {
                echo "PATH = %PATH%"
                echo "M2_HOME = %JAVA_HOME%"
            }
        }
        stage('Build'){
            steps{
                sh 'mvn clean compile test package'
            }
        }
        stage('SonarQube Analysis'){
            steps{
                withSonarQubeEnv('SonarQube1'){
                    bat 'mvn sonar:sonar'
                }
            }
        }
        stage('JaCoCo'){
            steps{
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