pipeline {
    agent any
    stages {
        //     This pipeline is a demo to show user prompt and parallel execution of jobs and one parallel job execution on Slave node.
                stage('One') {
                        steps {
                                echo 'Hi, this is Krunal just messing around with the pipeline'
                        }
                }
                stage('Two'){
                        
                        steps {
                                input('Do you want to proceed?')
                }
                }
                stage('Three') {
                        steps {
                                echo "Hello"
                                }
                }
                stage('Four') {
                        parallel {
                                stage('Unit Test') {
                                        steps
                                        {
                                        echo "Running the unit test..."
                                        }
                                }
                                stage('Integration test') {
                                agent 
                                        { 
                                        label 'Slave1' 
                                        }
                                        
                                steps 
                                        {
                                        echo 'Running the integration test..'
                                        }
                                        
                                }
                        }
                                        
                }  

        }
}
