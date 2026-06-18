package com.example.visibility

// public is the default visibility modifier in Kotlin.
// Members declared as public are accessible from anywhere.
public class PublicClass {
    public fun publicFunction() {
        println("This is a public function.")
    }
}

// protected members are accessible within the class itself and its subclasses.
// They are NOT accessible from outside the class hierarchy.
open class ProtectedBaseClass {
    protected fun protectedFunction() {
        println("This is a protected function.")
    }
}

class ProtectedDerivedClass : ProtectedBaseClass() {
    fun callProtected() {
        // Accessible from subclass
        protectedFunction()
    }
}

// internal members are accessible only within the same module.
A module is a set of Kotlin files compiled together (e.g., a Maven or Gradle module).
// They are NOT accessible from outside the module, even if they are in the same package.
internal class InternalClass {
    internal fun internalFunction() {
        println("This is an internal function.")
    }
}

// private members are accessible only within the declaring class or file.
class PrivateClass {
    private fun privateFunction() {
        println("This is a private function.")
    }

    fun callPrivate() {
        // Accessible within the same class
        privateFunction()
    }
}

fun main() {
    // Demonstrating public
    val publicObj = PublicClass()
    publicObj.publicFunction() // Accessible from anywhere

    // Demonstrating protected (via derived class)
    val protectedObj = ProtectedDerivedClass()
    protectedObj.callProtected() // Accessible via derived class method
    // protectedObj.protectedFunction() // ERROR: protectedFunction() is protected

    // Demonstrating internal
    val internalObj = InternalClass()
    internalObj.internalFunction() // Accessible within the same module

    // Demonstrating private
    val privateObj = PrivateClass()
    privateObj.callPrivate() // Accessible within the same class
    // privateObj.privateFunction() // ERROR: privateFunction() is private

    println("Visibility modifiers demonstration complete.")
}
