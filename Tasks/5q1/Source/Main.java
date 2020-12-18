public class Main {

   public static void main(String[] args) {
      CarQueue car_que = new CarQueue(5);
      
      Car car1 = new Car("CAR 1", 10, 2017);
      Car car2 = new Car("CAR 2", 20, 2018);
      Car car3 = new Car("CAR 3", 30, 2019);
      Car car4 = new Car("CAR 4", 40, 2020);
      Car car5 = new Car("CAR 5", 50, 2021);
      
      car_que.Insert(car1);
      car_que.Print();

      car_que.Insert(car2);
      car_que.Print();

      car_que.Insert(car3);
      car_que.Print();

      car_que.Insert(car4);
      car_que.Print();

      car_que.Insert(car5);
      car_que.Print();
         

      car_que.Remove();
      car_que.Print();
      
      Car car6 = new Car("CAR 6", 60, 2022);
      car_que.Insert(car6);
      car_que.Print();
      
      car_que.Remove();
      car_que.Print();

      car_que.Remove();
      car_que.Print();

      Car car7 = new Car("CAR 7", 70, 2023);
      car_que.Insert(car7);
      car_que.Print();
   }

}
