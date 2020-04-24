package extending.bean

import grails.testing.mixin.integration.Integration
import grails.util.Holders
import spock.lang.Specification
import spock.lang.Unroll

@Integration
class BeanCreationIntegrationSpec extends Specification {

    @Unroll
    void "creating named bean #named works"() {

        given: "an application context"
        def ctx = Holders.grailsApplication.mainContext

        when: "asking for bean #named with the value #value"
        def bean = ctx.getBean(named, value) as ValueBean

        then: "I get a bean of type #named"
        bean.class.simpleName == named

        and: "the value of the bean is #value"
        bean.value == value

        where:
        named   | value
        'BeanA' | 'Value A'
        'BeanB' | 'Value B'
    }

    @Unroll
    void "creating a bean of type #className works"() {

        given: "an application context"
        def ctx = Holders.grailsApplication.mainContext

        when: "asking for bean of type #className and the value #value"
        def bean = ctx.getBean(Class.forName(className), value) as ValueBean

        then: "I get a bean of type #className"
        bean.class.name == className

        and: "the value of the bean is #value"
        bean.value == value

        where:
        className              | value
        'extending.bean.BeanA' | 'Value 1'
        'extending.bean.BeanB' | 'Value 2'
    }
}
