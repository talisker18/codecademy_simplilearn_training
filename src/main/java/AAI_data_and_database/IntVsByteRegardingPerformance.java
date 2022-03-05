package AAI_data_and_database;

/*
 * 
 * 

 Question:---------   Am I wrong in assuming it should be faster and more efficient? I'd hate to go through and change everything in a massive program to find out I wasted my time.

Short answer---------------

Yes, you are wrong. In most cases, it makes little difference in terms of space used.

It is not worth trying to optimize this ... unless you have clear evidence that optimization is needed. And if you do need to optimize memory usage of object fields in particular, you will probably need to take other (more effective) measures.


Longer answer-------------------

The Java Virtual Machine models stacks and object fields using offsets that are (in effect) multiples of a 32 bit primitive cell size. So when you declare a local variable or object field as (say) a byte, the variable / field will be stored in a 32 bit cell, just like an int.

There are two exceptions to this:

    long and double values require 2 primitive 32-bit cells
    arrays of primitive types are represent in packed form, so that (for example) an array of bytes hold 4 bytes per 32bit word.

So it might be worth optimizing use of long and double ... and large arrays of primitives. But in general no.

In theory, a JIT might be able to optimize this, but in practice I've never heard of a JIT that does. One impediment is that the JIT typically cannot run until after there instances of the class being compiled have been created. If the JIT optimized the memory layout, you could have two (or more) "flavors" of object of the same class ... and that would present huge difficulties.


Revisitation-------------------

Looking at the benchmark results in @meriton's answer, it appears that using short and byte instead of int incurs a performance penalty for multiplication. Indeed, if you consider the operations in isolation, the penalty is significant. (You shouldn't consider them in isolation ... but that's another topic.)

I think the explanation is that JIT is probably doing the multiplications using 32bit multiply instructions in each case. But in the byte and short case, it executes extra instructions to convert the intermediate 32 bit value to a byte or short in each loop iteration. (In theory, that conversion could be done once at the end of the loop ... but I doubt that the optimizer would be able to figure that out.)

Anyway, this does point to another problem with switching to short and byte as an optimization. It could make performance worse ... in an algorithm that is arithmetic and compute intensive.
 * 
 * 
 * 
 * 
 * */

public class IntVsByteRegardingPerformance {

}
