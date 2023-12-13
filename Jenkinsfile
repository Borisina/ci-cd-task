pipeline {
    agent any
    environment{
        SCANNER_HOME = tool 'SQScanner'
    }
    tools {
        maven 'MavenLocal'
        jdk 'jdk17'
    }
    stages {
        stage ('Initialize') {
            steps {
                bat '''
                    echo "PATH = %PATH%"
                    echo "M2_HOME = %M2_HOME%"
                '''
            }
        }

        stage ('Build') {
            steps {
                bat 'mvn clean compile test package'
            }
        }

        stage('SonarQube Analysis'){
            steps{
                withSonarQubeEnv('SonarQube1'){
                    bat 'mvn sonar:sonar'
                }
            }
        }
    }
}


// pipeline{
//     agent any
//     stages{
//         stage ('Initialize') {
//             steps {
//                 echo "PATH = %PATH%"
//                 echo "M2_HOME = %JAVA_HOME%"
//             }
//         }
//         stage('Build'){
//             steps{
//                 sh 'mvn clean compile test package'
//             }
//         }
//         stage('SonarQube Analysis'){
//             steps{
//                 withSonarQubeEnv('SonarQube1'){
//                     bat 'mvn sonar:sonar'
//                 }
//             }
//         }
//         stage('JaCoCo'){
//             steps{
//                 jacoco()
//             }
//         }
//         stage('Deploy'){
//             steps{
//                 waitForQualityGate abortPipeline: false, credentialsId: 'token-for-jenkins'
//                 deploy adapters: [tomcat9( credentialsId: 'tomcat-9-token', path: '', url: 'http://localhost:8088/')], contextPath: null, onFailure: false, war: '**/*.war'
//             }
//         }
//     }
// }