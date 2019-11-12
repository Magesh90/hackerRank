package com.basic.observables

import java.util.concurrent.Callable

class CustomCallable implements Callable<Integer>{
    @Override
    Integer call() throws Exception {
        return 23
    }
}
