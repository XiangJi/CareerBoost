# Greedy

## Concept

贪心的奥义就是每一步都选择当前回合”可见范围“（即可得知的信息）内的最优，而在每一步都仅选择当前回合”可见范围“内的最优这一策略下能够导致全局最优的结果的情况使用贪心就会是正确的，否则不适用贪心（或不适用当前对贪心中的最优的定义）。

因此，贪心一个点是选择当前最优，另一个点是这个最优要怎么定义，比如是选使得A最小的还是选使得A-B或A/B最小的等等。



贪心的正确性其实都要通过归纳法或反证法等手段进行严格地证明, 做题就找规律

最优子结构性质是比较容易看出来的，但是贪心选择性质就没那么容易了，这个时候需要证明。证明往往使用数学归纳法。 



### Practice

Candy

Gas Station

Jump Game I II

MaxChunksToMakeSorted

patching array

Queue Reconstruction by Height

Rearrange String k Distance Apart

SplitArrayintoConsecutiveSubsequences

task scheduler