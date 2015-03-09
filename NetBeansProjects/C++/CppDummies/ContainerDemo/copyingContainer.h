/* 
 * File:   copyingContainer.h
 * Author: alice
 *
 * Created on June 5, 2014, 10:42 PM
 */

#ifndef COPYINGCONTAINER_H
#define	COPYINGCONTAINER_H

class copyingContainer {
public:
    copyingContainer();
    copyingContainer(const copyingContainer& orig);
    virtual ~copyingContainer();
    void copyingContainerExample();
private:

};

#endif	/* COPYINGCONTAINER_H */

