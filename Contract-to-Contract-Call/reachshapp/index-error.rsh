A.only(() => {
    const info = declassify(interact.info); //declassify amount of tokens
    A.publish(info); 
    transfer(request - 1).to(A); 
    commit();
})