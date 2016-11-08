/**
 * Usage: <b> 线程执行者 </b>
 * 1. 使用 Executors 框架, cachedPool OR fixedPool
 * 2. 执行返回结果的任务，有两种：Callable, Future
 * 3. 运行多个任务，处理首个结果, using ExecutorService.invokeAny()
 *
 * @author lucifer
 * Date 2016-9-27
 * Device Aurora R5
 */
package concurrency.ch4ThreadExecutor;