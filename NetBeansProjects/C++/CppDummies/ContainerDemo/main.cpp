#include <cstdlib>
#include <iostream>

#include "vectorDemo.h"
#include "mapDemo.h"
#include "iteratorDemo.h"
#include "setDemo.h"
#include "listDemo.h"
#include "dequeDemo.h"
#include "stackQueue.h"
#include "copyingContainer.h"

using namespace std;

int main() {
    vectorDemo vd;
    vd.vectorExample();
    
    mapDemo md;
    md.mapExample();
    
    iteratorDemo id;
    id.iteratorExample();
    
    setDemo sd;
    sd.setExample();
    
    listDemo ld;
    ld.listExample();
    
    dequeDemo dd;
    dd.dequeExample();
    
    stackQueue sq;
    sq.stackQueueExample();
    
    copyingContainer cc;
    cc.copyingContainerExample();
    
    return 0;
}

