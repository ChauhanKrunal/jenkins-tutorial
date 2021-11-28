pipeline{
    // This shows a demo of of how you can set upstream triggers and set downstream jobs in pipeline.
    agent any
    triggers{
        upstream(upstreamProjects: "upstream_job",
        threshold: hudson.model.Result.SUCCESS)//UNSTABLE, FAILURE, NOT_BUILT, ABORTED
    }
    stages{
        stage("Build"){
            steps{
                echo 'Building after upstream job executed'
            }
        }
        stage("Downstream"){
            steps{
                build job: "python_demo"
            }
        }
    }
}