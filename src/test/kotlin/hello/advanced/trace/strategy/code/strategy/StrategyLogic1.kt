package hello.advanced.trace.strategy.code.strategy

class StrategyLogic1 : Strategy {
    override fun call() {
        println("비즈니스 로직1 실행")
    }
}