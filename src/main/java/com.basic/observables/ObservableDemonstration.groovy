package com.basic.observables

import rx.Observable
import rx.Scheduler
import rx.schedulers.Schedulers

import java.util.concurrent.FutureTask

class ObservableDemonstration {

    public static void main(String[] args) {

        Observable observable = Observable.from(new Integer(2))

        observable.subscribe({ i ->
            println("My first observable int=$i")
        })

        Observable listObservable = Observable.from([1, 2, 3, 4])
        listObservable.subscribe({
            println("Observable for list = $it")
        })

        FutureTask<List<Integer>> futureTask = new FutureTask(new CustomCallable())
        Observable futureObservable = Observable.from(futureTask)

        Scheduler scheduler = Schedulers.computation()
        scheduler.createWorker().schedule({
            futureTask.run()
        })

        futureObservable.subscribe({
            println("from future task=$it")
        })
    }
}
