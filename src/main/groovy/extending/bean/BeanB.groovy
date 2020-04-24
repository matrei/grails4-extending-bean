package extending.bean

import io.micronaut.context.annotation.Prototype

import javax.inject.Named

@Prototype
@Named('BeanB')
class BeanB extends BeanA {

    BeanB(String value) {
        super(value)
    }
}
