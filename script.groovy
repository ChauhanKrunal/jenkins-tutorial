def buildApp(){
    echo "Building the project"
}

def testApp(){
    echo "Testing the project"
}

def deployApp(){
    echo "Deploying the project with version ${params.VERSION}"
}

return this