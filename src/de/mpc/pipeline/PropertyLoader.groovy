package de.mpc.pipeline

class PropertyLoader implements Serializable {
    def steps
    def properties

    PropertyLoader(steps) { this.steps = steps }

    def init() {
        properties = steps.readYaml file: 'jenkins-properties.yml'
        printProperties(properties)
    }

    def getMailRecipients() {
        def mailRecipients = properties['mailRecipients']
        return mailRecipients
    }

    def runUnitTests() {
        def runUnitTests = properties['hasUnitTests']
        return runUnitTests
    }


    private void printProperties(properties) {
        steps.echo "Loaded properties from jenkins-properties.yml are: "
        for (property in properties) {
            steps.echo "${property.key} = ${property.value}"
        }
    }
}