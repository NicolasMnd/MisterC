# MisterC
MisterC is based upon the controller principle of GRASP. It creates a MisterC object and will block while asking for input. The object is instantiated
with a ``InputHandler``. This ``InputHandler`` interface provides ``InputType getInput()`` and ``boolean stop(InputType)``. 

For example, a ``Scanner`` implementation would return a ``InputType<String>`` by reading in ``System.in``. The ``stop(InputType)`` describes
a way for testing environments to stop asking for input & end the test. Subclasses of ``InputHandler`` will return a specific generic value.
When ``MisterC`` object is started by calling ``MisterC#loop()``, it will ask for input indefinitely until ``stop(InputType)`` is true.

Handling of the input is delegated to a ``Controller`` object providing ``void paint()`` and ``ActionResult handle(InputType)``. Every
``MisterC`` object will allow users to ``setController(Controller)``, providing the start controller. Each ``Controller`` contains a
'previous' controller, so when certain input should be handled by another class or allows transition to another stage in the program,
the ``Controller`` can do ``Controller.currentProgram.setController(Controller)``. So users should implement controller transition
carefully.

For complex programs, which should be able to go through several 'states', the user can employ ``ControllerFlow``. This is a subclass
of ``Controller`` and offers some extra functionality by implementing the State structural design pattern. ``MisterC`` does not know
of states and will just delegate input to the controller.

``ControllerFlow`` will force the user to set a 'starting' ``BaseState`` object, which implements ``State``. A ``State`` can ``State#render()``
and ``State#handle(InputType)``. So ``ControllerFlow`` will have one ``BaseState`` representing the current state of the program, and ask
each state to render itself and handle input. The states will transition themselves by using ``protected void nextState(BaseState)``. This
will modify ``ControllerFlow#state``. Swift transition between states is possible.
