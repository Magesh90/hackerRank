 class DemoExample {
    interface myINter{
        public void dumm();
    }

    static class staticclass implements myINter{
        public void dumm(){
            System.out.println("ilkafkln");
        }
    }

    public static void main(String[] args) {
        DemoExample.staticclass staticclass = new DemoExample.staticclass();
        staticclass.dumm();
    }
}
