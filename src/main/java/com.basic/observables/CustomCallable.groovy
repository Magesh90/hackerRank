package com.basic.observables

import java.time.Instant
import java.util.concurrent.Callable

class CustomCallable implements Callable<Integer>{
    @Override
    Integer call() throws Exception {
        println("Printing from custom callable "+ Date.from(Instant.now()))
        return 23
    }
}
