pipeline {
    agent any
    
    parameters { 
         string(name: 'tomcat_dev', defaultValue: '13.233.134.94', description: 'Staging Server')
         string(name: 'tomcat_prod', defaultValue: '13.127.86.158', description: 'Production Server')
    } 
 
    triggers {
         pollSCM('* * * * *') // Polling Source Control
     }
 


 
 
stages{
        stage('Build'){
            steps {
                bat 'mvn clean package'
            }
            post {
                success {
                    echo 'Now Archiving...'
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }
        }
 
        stage ('Deployments'){
            parallel{
                stage ('Deploy to Staging'){
                    steps {
                        bat "echo y | pscp -i /C:/Users/haroon_raizada/Downloads/tomcat-demo.pem /C:/Users/haroon_raizada/.jenkins/workspace/FullyAutomated/target/*.war ec2-user@${params.tomcat_dev}:/var/lib/tomcat7/webapps"
                    }
                }
 
                stage ("Deploy to Production"){
                    steps {
                        bat "echo y | pscp -i /C:/Users/haroon_raizada/Downloads/tomcat-demo.pem /C:/Users/haroon_raizada/.jenkins/workspace/FullyAutomated/target/*.war ec2-user@${params.tomcat_prod}:/var/lib/tomcat7/webapps"
                    }
                }
            }
        }
    }
}
