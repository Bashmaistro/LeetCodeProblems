/*
 * @lc app=leetcode id=1207 lang=typescript
 *
 * [1207] Unique Number of Occurrences
 */

// @lc code=start
function uniqueOccurrences(arr: number[]): boolean {

    const result = new Map<number, number>();
    const resultBoolean = new Array<number>();

    for (let i = 0; i < arr.length ; i++){

        //Check is there any entry in map
        if (result.has(arr[i])) {
            result.set(arr[i], (result.get(arr[i]) || 0) + 1);
        } else {
            result.set(arr[i], 1);
        }
        
    }

    for (let key of result.values()) {  
        
        if (resultBoolean.some((element)=>{return element == key;})) 
        {
            return false;
        }else{
            resultBoolean.push(key);
        }
    }  

    return true;


    
    
};
// @lc code=end

