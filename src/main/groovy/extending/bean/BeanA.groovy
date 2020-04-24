package extending.bean

import io.micronaut.context.annotation.Prototype

import javax.inject.Named

@Prototype
@Named('BeanA')
class BeanA implements ValueBean {

    BeanA(String value) {
        this.value = value
    }
}
