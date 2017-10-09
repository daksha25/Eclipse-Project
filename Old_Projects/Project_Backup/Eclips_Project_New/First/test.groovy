import org.codehaus.groovy.runtime.InvokerHelper
class Main extends Script {
    int power(int n) { 2** n}                   
    def run() {
        println 'Hello'                         
        println "2^6==${power(6)}"              
    }
    static void main(String[] args) {
        InvokerHelper.runScript(Main, args)
    }
}