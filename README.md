# Demos for patterns in DDD

This repository contains the demos for the second half of the `Pattern in DDD` presentation, which is part of the Sogyo DDD master course.

### Domain models (Java/Scala)

This is a longer demo that transforms an anemic domain model to a more aggregate-like model in several steps. This demo has both an [OOP variant](./src/main/java/demos/oop/order) and an [FP variant](./src/main/scala/demos/fp/order).

The code in this demo is built using `sbt`.

The demo goes through the following steps.

1. The anemic model can be found in the `anemic` namespace ([OOP](./src/main/java/demos/oop/order/anemic); [FP](./src/main/scala/demos/fp/order/anemic)).
2. The demo for encapsulating and information hiding proceeds in two steps. First, the behaviour is grouped with the data in the `nohiding` namespace ([OOP](./src/main/java/demos/oop/order/nohiding); [FP](./src/main/scala/demos/fp/order/nohiding)). Then, relevant methods are removed or made private in the `hiding` namespace ([OOP](./src/main/java/demos/oop/order/hiding); [FP](./src/main/scala/demos/fp/order/hiding)).
3. A smart constructor is added in the `smartconstructor` namespace ([OOP](./src/main/java/demos/oop/order/smartconstructor); [FP](./src/main/scala/demos/fp/order/smartconstructor)).
4. Finally, a refactoring is done in the `refactoring` namespace ([OOP](./src/main/java/demos/oop/order/refactoring); [FP](./src/main/scala/demos/fp/order/refactoring)).

### Entity vs. service (Python)

This demo has an [OOP variant](./demos/bank/oop) and an [FP variant](./demos/bank/fp).

### Dependency injection (Python)

This demo proceeds in two stages. In order to run it, you should first install the dependencies (preferably in a virtual environment):

```bash
pip install -r requirements.txt
```

1. First, an example without dependency injection can be found [here](./demos/user/direct). In order to make the tests pass, a local RavenDB should be running, which can be started using:

   ```bash
   docker compose up
   ```

   <details>
   <summary>
   If this throws a permission error...
   </summary>
   You should probably run something like this:

   ```bash
   sudo chown -R 999:999 ~/.RavenDB-usertest
   ```

   </details>

   Go to `localhost:8080` and add a database called `User`.

2. Then, an example with dependency injection, which can be found [here](./demos/user/injected). This demo does not require a database to be running (which is kind of the point of the demo).
