pipeline {
    agent any
    
    parameters { 
         string(name: 'tomcat_dev', defaultValue: '13.233.134.94', description: 'Staging Server')
         string(name: 'tomcat_prod', defaultValue: '13.127.86.158', description: 'Production Server')
    } 
 
    triggers {
         pollSCM('* * * * *') // Polling Source Control
     }
 
A Working Jenkinsfile example for Windows
Section 5, Lecture 49
Step 1 : 
Install winscp

Step 2: 
Add the following to the PATH environment variable

system32 path, for example C:\Windows\System32 
path to maven installation, for example C:\apache-maven-3.5.2\bin 
path to scp command, for example C:\Program Files (x86)\WinSCP 
Step 3: 
Jenkinfile example:

pipeline {
    agent any
    
    parameters { 
         string(name: 'tomcat_dev', defaultValue: '35.166.210.154', description: 'Staging Server')
         string(name: 'tomcat_prod', defaultValue: '34.209.233.6', description: 'Production Server')
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
                        bat "winscp -i /home/jenkins/tomcat-demo.pem **/target/*.war ec2-user@${params.tomcat_dev}:/var/lib/tomcat7/webapps"
                    }
                }
 
                stage ("Deploy to Production"){
                    steps {
                        bat "winscp -i /home/jenkins/tomcat-demo.pem **/target/*.war ec2-user@${params.tomcat_prod}:/var/lib/tomcat7/webapps"
                    }
                }
            }
        }
    }
}
