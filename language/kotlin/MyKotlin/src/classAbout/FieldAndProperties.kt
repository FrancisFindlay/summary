package classAbout

class Address {
    var name: String = "francis"
    var street: String = "Baker"
    var city: String = "London"
    var state: String? = null


    override fun toString(): String {
        return "Address(name='$name', street='$street', city='$city', state=$state)"
    }
}


fun copyAddress(address: Address): Address {
    val result = Address()
    result.name = address.name
    result.street = address.street
    return result
}

/**
 * getter and setter
 *
 * 声明一个属性的完整语法是:
 * var <propertyName>[: <PropertyType>] [= <property_initializer>]
 *                                          [<getter>]
 *                                          [<setter>]
 *
 * 其初始器(initializer)、getter 和 setter 都是可选的。
 * 属性类型如果可以从初始器 (或者从 其 getter 返回值，如下文所示)中推断出来，也可以省略。
 *
 *
 * 一个只读属性的语法和一个可变的属性的语法有两方面的不同:
 * 1、只读属性的用 val 开始 代替 var
 * 2、只读属性不允许 setter
 *
 *
 */


/**
 * 幕后字段:
 *
 * 我们可以为属性定义自定义的访问器。
 * 如果我们定义了一个自定义的 getter，那么每次访问该 属性时都会调用它 (这让我们可以实现计算出的属性)。
 * 如果我们定义了一个自定义的 setter，那么每次给属性赋值时都会调用它。
 * 按照惯例，setter 参数的名称是 value ，但是如果你喜欢你可以选择一个不同的名称。
 *
 * 是不是Kotlin 所有属性都会有幕后字段呢？当然不是，需要满足下面条件之一：
 *      使用默认 getter / setter 的属性，一定有幕后字段。对于 var 属性来说，只要 getter / setter 中有一个使用默认实现，就会生成幕后字段；
 *      在自定义 getter / setter 中使用了 field 的属性
 *
 * 有幕后字段的属性转换成Java代码一定有一个对应的Java变量!!!
 *
 */

/**
 *
 */

class BackingFields {

    var name = "defaultName"

        get() = field.toString()

        set(value) {
            field = value + ", hello!" // 为了给name赋值，就需要用到幕后字段... field指向当前属性。
            // name = value  这句话报错的原因， 访问name实际就是调用了set，因此出现了自己调用自己的递归...
        }

    var size = 0
    var isEmpty // 没有生成幕后字段
        get() = size == 0
        set(value) {
            size *= 2
        }
}

/**
 * 幕后属性
 * 有时候有这种需求，我们希望一个属性：对外表现为只读，对内表现为可读可写，我们将这个属性成为幕后属性。 如：
 *
 */

class BackingProperties {
    private var _table: Map<String, Int>? = null
    public val table: Map<String, Int>
        get() {
            if (_table == null) {
                _table = HashMap()
            }
            return _table ?: throw AssertionError("set to null...")
        }
}


fun main() {
    val address = copyAddress(Address())
    var allByDefault: Int? // var allByDefault 类型无法推断，所以必须显式声明类型
    var initialized = 1 // 推断为Int, 默认get and set

    val simple: Int
    val inferredType = 1

    val p = BackingFields()
    p.name = "Francis"
    print(p.name)
}