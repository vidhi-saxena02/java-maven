def buildJar() {
    echo 'building the application'
    sh 'mvn package'
}  

def buildImage(){
    echo 'testing the application'
    withCredentials([usernamePassword(credentialsId: 'dockercred',passwordVariable: 'PASS', usernameVariable: 'USER')]){
        sh 'docker build -t vidhi2002/demo-app:jma-2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push vidhi2002/demo-app:jma-2.0'
    }    
}

def deployApp(){
    echo 'deploying the application' 
}  

return this
