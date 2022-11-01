def gv

pipeline {
    agent any
    tools {
        maven "maven-3.6"
    }    
    stages {
        stage('init') { 
            steps {
                script {
                   gv = load "script.groovy"
                }    
            }
        }
        stage('build jar') { 
            steps {
                script{
                    gv.buildJar()
                    echo "Executing pipeline for branch $BRANCH_NAME"
                }    
            }
        }
        stage('build image') {
            when {
                expression {
                    BRANCH_NAME == 'master'
                }
            }
            steps {
                script{
                    gv.buildImage()
                } 
            }
        }
        stage('Deploy') {
            when {
                expression {
                    BRANCH_NAME == 'master'
                }
            }
            steps {
                script{
                    gv.deployApp() 
                } 
            }
        }
    }
}
