package com.aca.classroom.week13.buff;


    public final class SafeBuffer<T> implements Buffer<T> {

        private T value;

        @Override
        public T get() {
            while (value == null) {
                throw new IllegalStateException("the buffer is empty");
            }
            T valueToReturn = value;
            value = null;
            notifyAll();
            return valueToReturn;
        }

        @Override
        public void put(final T t)throws InterruptedException {
            if(value == null) {
                throw new IllegalArgumentException("the provided value is null");
            }/*
        if (value != null) {
            throw new IllegalStateException("the buffer is full");
        }
        */
           //while
            if(value!=null){
                wait();
            }
            this.value = t;
        }

        public static void main(String[] args) {
            final Buffer<Integer>  buffer = new SafeBuffer<>();
            // for( int i =;i<1000;i++){


            }
        }

