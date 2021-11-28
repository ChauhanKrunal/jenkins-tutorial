def gv
pipeline {
    agent any
    // This shows a demo of how to use external groovy script file inside the pipeline stages.
    parameters{
        choice(name: "VERSION", choices: ["1.0.0", "1.1.0", "1.2.0"], description:"Different Dev Versions")
        booleanParam(name: "EXECUTE_TESTS", defaultValue: true, description:"")
    }
    stages {
        stage("Build") {
            steps {
                script
                {
                    gv = load "script.groovy"
                    gv.buildApp()
                }
            }
        }
        stage("Test") {
            steps {
                script
                {
                    gv.testApp()
                }
            }
        }
        stage("Release") {
            steps {
                script
                {
                    gv.deployApp()
                }
            }
        }
    }
}