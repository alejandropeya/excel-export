grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"

grails.project.repos.peya.url = "http://54.209.219.49:8081/nexus/content/repositories/thirdparty/"
grails.project.repos.peya.type = "maven"
grails.project.repos.peya.username = "deployment"
grails.project.repos.peya.password = "peya"
grails.project.repos.default = "peya"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
        excludes 'xercesImpl', 'xml-apis'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsCentral()
        mavenCentral()

        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        //mavenLocal()
        //mavenCentral()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
		mavenRepo "http://repo.grails.org/grails/repo/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        compile (group:'org.apache.poi', name:'poi', version:'3.12');
        compile (group:'org.apache.poi', name:'poi-ooxml', version:'3.12') {
            excludes 'stax-api'
        }
        compile ('org.apache.poi:poi-ooxml-schemas:3.12') {
            excludes 'stax-api'
        }
        compile ('dom4j:dom4j:1.6.1')
        runtime('xerces:xercesImpl:2.10.0') {
            excludes 'xml-apis'
        }
    }
    plugins {
        build ':release:2.2.1', ':rest-client-builder:1.0.3', {
            export = false
        }
    }
}
