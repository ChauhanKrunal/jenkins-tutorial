pipeline {
    agent any
    parameters{
        choice(name: "VERSION", choices: ["1.0.0", "1.1.0", "1.2.0"], description:"Different Dev Versions")
        booleanParam(name: "EXECUTE_TESTS", defaultValue: true, description:"")
    }
    stages {
        // This pipeline shows a demo of how to use parameters and to use those params in conditional block.
        stage('Build') {
            steps {
                echo 'Hi, myself intro not needed just messing around with the pipeline'
                echo "The project is in builiding phase"
            }
        }
        stage('Testing') {
            when
            {
                expression
                {
                    params.EXECUTE_TESTS == true
                }
            }
                steps
                {
                    echo "The project is in testing phase"
                }
        }
        stage('Deploy') {
            steps {
                echo "The project is in release phase with version ${params.VERSION}"
            }
        }
    }
}