pipeline {
    agent none
    stages {
        // This pipeline is a demo of post block usually denoted as a downstream block and generally adding post block to the end of piepline and stages
        // denotes a good convention.
        stage('One') {
            steps {
                echo 'Hi, myself intro ahhh, not needed just messing around with the pipeline'
            }
        }
        stage('Two') {
            steps {
                echo "Denotes step 2"
            } 
        }
        stage('Three') {
            steps {
                echo "Denotes step 3"
            }
        }
    }
    post { 
        always { 
            echo 'Run regardless of the completion status of the Pipeline run.'
        }
        succes { 
            echo 'Only run if the current Pipeline has a "success" status, typically denoted in the web UI with a blue or green indication.'
        }
        failure { 
            echo 'Only run if the current Pipeline has a "failed" status, typically denoted in the web UI with a red indication.'
        }
        changed { 
            echo 'Only run if the current Pipeline run has a different status from the previously completed Pipeline'
        }
        unstable { 
            echo 'Only run if the current Pipeline has an "unstable" status, usually caused by test failures, code violations, etc. Typically denoted in the web UI with a yellow indication.'
        }
    }
}